import { NextFunction, Request, Response } from 'express';

export interface Middleware {
  (req: Request, res: Response, next?: NextFunction): (
    req: Request,
    res: Response,
    next?: NextFunction
  ) => any;
}
