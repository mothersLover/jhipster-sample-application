import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import STIRCase from './stir-case';
import STIRCaseDetail from './stir-case-detail';
import STIRCaseUpdate from './stir-case-update';
import STIRCaseDeleteDialog from './stir-case-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={STIRCaseUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={STIRCaseUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={STIRCaseDetail} />
      <ErrorBoundaryRoute path={match.url} component={STIRCase} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={STIRCaseDeleteDialog} />
  </>
);

export default Routes;
