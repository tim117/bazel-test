import { Middleware } from './middleware';

export interface Route {
  middlewares: Middleware[];
  handler?: Middleware;
  path: string;
  method: HttpMethod;
}

export enum HttpMethod {
  CONNECT = 'CONNECT',
  DELETE = 'DELETE',
  GET = 'GET',
  HEAD = 'HEAD',
  OPTIONS = 'OPTIONS',
  POST = 'POST',
  PATCH = 'PATCH',
  PUT = 'PUT',
  TRACE = 'TRACE',
}
