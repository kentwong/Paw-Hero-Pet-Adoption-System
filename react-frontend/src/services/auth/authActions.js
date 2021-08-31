import { LOGIN_REQUEST, LOGOUT_REQUEST, SUCCESS, FAILURE } from './authTypes';

export const authenticateUser = (emailAddress, password) => {
    return dispatch => {
        dispatch(loginRequest());
        if (emailAddress === "test" && password === "test") {
            dispatch(success(true));
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

const logoutRequest = () => {
    return {
        type: LOGOUT_REQUEST
    }
}

export const logoutUser = () => {
    return dispatch => {
        dispatch(logoutRequest());
        dispatch(success(false));
    }
}

const success = isLoggedIn => {
    return {
        type: SUCCESS,
        payload: isLoggedIn
    }
}

const failure = () => {
    return {
        type: FAILURE,
        payload: false
    }
}