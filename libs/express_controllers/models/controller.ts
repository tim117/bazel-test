import { HttpMethod, Route } from './route';
import { Router } from 'express';
import { Middleware } from './middleware';

export class Controller {
  #path: string;
  #routes: Route[] = [];
  #parent?: Controller;
  #router: Router;

  constructor(
    path: string,
    router: Router,
    parent?: Controller,
    controllerMiddlewares: Middleware[] = []
  ) {
    path = path.trim();
    if (path.endsWith('/')) {
      path = path.slice(0, -2);
    }
    this.#path = path;
    this.#router = router;
    this.#parent = parent;
    for (const middleware of controllerMiddlewares) {
      this.addControllerMiddleware(middleware);
    }
  }

  get path(): string {
    const path = this.#path.startsWith('/') ? this.#path : '/' + this.#path;
    if (this.parent) {
      const parentPath = this.parent.path.startsWith('/')
        ? this.parent.path
        : '/' + this.parent.path;
      return parentPath + path;
    }
    return path;
  }

  get parent() {
    return this.#parent;
  }

  setParent(parent: Controller) {
    this.#parent = parent;
    return this;
  }

  addChildController(child: Controller) {
    child.setParent(this);
    return this;
  }

  addControllerMiddleware(middleware: Middleware) {
    this.#router.use(this.path, middleware);
    return this;
  }

  addControllerMiddlewares(...middlewares: Middleware[]) {
    for (const middleware of middlewares) {
      this.addControllerMiddleware(middleware);
    }
    return this;
  }

  addRoutes(...routes: Route[]) {
    for (const route of routes) {
      this.addRoute(route);
    }
    return this;
  }

  addRoute(route: Route) {
    route.path = route.path.startsWith('/') ? route.path : '/' + route.path;
    const path = this.path + route.path;
    const args: [string, ...Middleware[]] = [path, ...route.middlewares];
    if (route.handler) {
      args.push(route.handler);
    }
    switch (route.method) {
      case HttpMethod.CONNECT:
        this.#router.connect(...args);
      case HttpMethod.DELETE:
        this.#router.delete(...args);
      case HttpMethod.GET:
        this.#router.get(...args);
      case HttpMethod.HEAD:
        this.#router.head(...args);
      case HttpMethod.OPTIONS:
        this.#router.options(...args);
      case HttpMethod.PATCH:
        this.#router.patch(...args);
      case HttpMethod.POST:
        this.#router.post(...args);
      case HttpMethod.PUT:
        this.#router.put(...args);
      case HttpMethod.TRACE:
        this.#router.trace(...args);
      default:
        this.#router.all(...args);
    }
    this.#routes.push(route);
    return this;
  }

  logRoutes() {
    console.log(this.#path);
    console.table(
      this.#routes.map((route) => ({ method: route.method, path: route.path })),
      ['method', 'path']
    );
    return this;
  }
}
