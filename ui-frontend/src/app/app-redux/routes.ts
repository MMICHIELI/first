import { RouteComponentProps } from 'react-router';

interface Routes {
    path: string;
      // tslint:disable-next-line no-any
      component: React.SFC<RouteComponentProps<any> | void> | React.ComponentClass<RouteComponentProps<any> | void>;
}

const routes: Array<Routes> = [

];

export default routes;