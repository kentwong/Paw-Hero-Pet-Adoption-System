import React from 'react';
import { connect } from 'react-redux';
import { logoutUser } from '../services/index'
// import PawHeroLogo from '../assets/images/pawherologo.png';

const HeaderComponent = (props) => {
    const logout = () => {
        props.logoutUser();
    }

    const guestLinks = (
        <>
            <div className="navbar-nav ms-auto">
                <li className="nav-item navbar-right">
                    <a className="nav-link" href="/login">Log In</a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="/signup">Sign Up</a>
                </li>
            </div>
        </>
    );

    const userLinks = (
        <>
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
                <li className="nav-item navbar-right">
                    <a className="nav-link" href="/logout" onClick={logout}>Log Out</a>
                </li>
            </div>
        </>
    );

    return (
        <div>
            <header>
                {/* <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div className="px-4">
                            <a href="./" className="navbar-brand">
                                <img src={PawHeroLogo} height="50" alt="Paw Hero's Logo" />
                            </a>
                        </div>
                    </nav> */}
                <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                    <div className="container-fluid">
                        <a className="navbar-brand" href="/">Paw Hero Adoption</a>
                        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarSupportedContent">


                            {props.auth.isLoggedIn ? userLinks : guestLinks}

                            {/* <form className="d-flex">
                                    <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                                    <button className="btn btn-outline-success" type="submit">Search</button>
                                </form> */}
                        </div>
                    </div>
                </nav>
            </header>
        </div>
    );
}

const mapStateToProps = state => {
    return {
        auth: state.auth
    }
}

const mapDispatchToProps = dispatch => {
    return {
        logoutUser: () => dispatch(logoutUser())
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(HeaderComponent);