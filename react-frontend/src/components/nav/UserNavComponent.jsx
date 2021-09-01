import React from 'react';
import { useDispatch, useSelector } from "react-redux";
import { logoutUser } from '../../services/index';

const UserNavComponent = () => {

    const auth = useSelector((state) => state.auth);
    const dispatch = useDispatch();

    const logout = () => {
        dispatch(logoutUser());
    }

    return (
        <div>
            <header>
                <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                    <div className="container-fluid">
                        <a className="navbar-brand" href="/">Paw Hero Adoption</a>
                        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                                <li className="nav-item">
                                    <a className="nav-link" href="/pets">Pets List</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="/addpet">Add Pets</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="/users">Users List</a>
                                </li>
                            </ul>
                            <div className="navbar-nav ms-auto">
                                <li className="nav-item text-light py-2 px-3">Welcome, {auth.name || localStorage.getItem("name")} </li>
                                <li className="nav-item navbar-right">
                                    <a className="nav-link btn text-light btn-danger" href="/" onClick={logout}>Log Out</a>
                                </li>
                            </div>
                        </div>
                    </div>
                </nav>
            </header>
        </div>
    );
}

export default UserNavComponent;