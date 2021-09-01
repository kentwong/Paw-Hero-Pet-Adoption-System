import { LOGIN_REQUEST, LOGOUT_REQUEST, SUCCESS, FAILURE } from './authTypes';

const initialState = {
    isLoggedIn: '',
    name: ''
}

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case LOGIN_REQUEST:
        case LOGOUT_REQUEST:
            return { ...state }
        case SUCCESS:
        case FAILURE:
            return {
                isLoggedIn: action.payload.isLoggedIn,
                name: action.payload.name,
                id: action.payload.id
            }
        default:
            return state
    }
}

export default reducer;