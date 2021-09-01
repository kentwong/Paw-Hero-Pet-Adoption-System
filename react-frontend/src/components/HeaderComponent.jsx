import React from 'react';
import { useSelector } from "react-redux";
import GuestNavComponent from './nav/GuestNavComponent';
import UserNavComponent from './nav/UserNavComponent';

const HeaderComponent = () => {

    const auth = useSelector((state) => state.auth);

    if ((auth.isLoggedIn) || (localStorage.getItem("isLoggedIn") === "true")) {
        return (<UserNavComponent />)
    }
    else {
        return (<GuestNavComponent />)
    }
}

export default HeaderComponent;