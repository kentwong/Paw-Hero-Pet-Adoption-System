import { LOGIN_REQUEST, LOGOUT_REQUEST, SUCCESS, FAILURE } from './authTypes';
import axios from 'axios';

const AUTH_URL = "http://localhost:8081/pawhero/user/auth"

export const authenticateUser = (emailAddress, password) => {
    return dispatch => {
        dispatch(loginRequest());

        axios.get(AUTH_URL + '/' + emailAddress)
            .then(res => {
                console.log(res.data)
                if (res.data.password === password) {
                    dispatch(success({ name: res.data.firstName, isLoggedIn: true }));
                    localStorage.setItem("name", res.data.firstName)
                    localStorage.setItem("role", res.data.role.name)
                    localStorage.setItem("isLoggedIn", true)
                } else {
                    dispatch(failure());
                }
            });
    }
}

export const logoutUser = () => {
    return dispatch => {
        dispatch(logoutRequest());
        localStorage.removeItem("name");
        localStorage.removeItem("role");
        localStorage.setItem("isLoggedIn", false)
        dispatch(success({ name: '', isLoggedIn: false }));
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