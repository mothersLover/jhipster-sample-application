import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ISTIRCase, defaultValue } from 'app/shared/model/stir-case.model';

export const ACTION_TYPES = {
  FETCH_STIRCASE_LIST: 'sTIRCase/FETCH_STIRCASE_LIST',
  FETCH_STIRCASE: 'sTIRCase/FETCH_STIRCASE',
  CREATE_STIRCASE: 'sTIRCase/CREATE_STIRCASE',
  UPDATE_STIRCASE: 'sTIRCase/UPDATE_STIRCASE',
  DELETE_STIRCASE: 'sTIRCase/DELETE_STIRCASE',
  RESET: 'sTIRCase/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ISTIRCase>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type STIRCaseState = Readonly<typeof initialState>;

// Reducer

export default (state: STIRCaseState = initialState, action): STIRCaseState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_STIRCASE_LIST):
    case REQUEST(ACTION_TYPES.FETCH_STIRCASE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_STIRCASE):
    case REQUEST(ACTION_TYPES.UPDATE_STIRCASE):
    case REQUEST(ACTION_TYPES.DELETE_STIRCASE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_STIRCASE_LIST):
    case FAILURE(ACTION_TYPES.FETCH_STIRCASE):
    case FAILURE(ACTION_TYPES.CREATE_STIRCASE):
    case FAILURE(ACTION_TYPES.UPDATE_STIRCASE):
    case FAILURE(ACTION_TYPES.DELETE_STIRCASE):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_STIRCASE_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_STIRCASE):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_STIRCASE):
    case SUCCESS(ACTION_TYPES.UPDATE_STIRCASE):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_STIRCASE):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {}
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState
      };
    default:
      return state;
  }
};

const apiUrl = 'api/stir-cases';

// Actions

export const getEntities: ICrudGetAllAction<ISTIRCase> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_STIRCASE_LIST,
  payload: axios.get<ISTIRCase>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<ISTIRCase> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_STIRCASE,
    payload: axios.get<ISTIRCase>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ISTIRCase> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_STIRCASE,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ISTIRCase> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_STIRCASE,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ISTIRCase> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_STIRCASE,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
