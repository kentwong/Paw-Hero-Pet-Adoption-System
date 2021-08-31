import { LOGIN_REQUEST, SUCCESS, FAILURE } from './authTypes';

export const authenticateUser = (emailAddress, password) => {
    return dispatch => {
        dispatch(loginRequest());
        if (emailAddress === "test" && password === "test") {
            dispatch(success());
        } else {
            dispatch(failure());
        }
    }
}

const loginRequest = () => {
    return {
        type: LOGIN_REQUEST
    }
}

const success = () => {
    return {
        type: SUCCESS,
        payload: true
    }
}

const failure = () => {
    return {
        type: FAILURE,
        payload: false
    }
}