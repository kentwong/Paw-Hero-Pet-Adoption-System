import React from 'react';

const GuestNavComponent = () => {
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
                            <div className="navbar-nav ms-auto">
                                <li className="nav-item navbar-right">
                                    <a className="nav-link" href="/login">Log In</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link btn text-light btn-danger" href="/signup">Sign Up</a>
                                </li>
                            </div>
                        </div>
                    </div>
                </nav>
            </header>
        </div>
    );
}

export default GuestNavComponent;