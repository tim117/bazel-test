import { Express } from 'express';
import { Controller } from './controller';
import { Middleware } from './middleware';

export class ExpressControllersApplication {
  #app: Express;
  #controllers: Controller[] = [];
  #port: number;

  constructor(app: Express, port: number) {
    this.#app = app;
    this.#port = port;
  }

  addMiddleware(middleware: Middleware) {
    this.use({ middlewares: [middleware] });
    return this;
  }

  addController(controller: Controller) {
    this.#controllers.push(controller);
    return this;
  }

  get app() {
    return this.#app;
  }

  use({ path, middlewares }: { path?: string; middlewares: Middleware[] }) {
    if (path) {
      this.#app.use(path, ...middlewares);
      return;
    }
    this.#app.use(...middlewares);
    return this;
  }

  run(port?: number) {
    this.#app.listen(port ?? this.#port, this.logAllRoutes);
  }

  logAllRoutes() {
    for (const controller of this.#controllers) {
      controller.logRoutes();
    }
  }
}

export const ECApp = ExpressControllersApplication;
