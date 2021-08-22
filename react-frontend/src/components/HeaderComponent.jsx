import React, { Component } from 'react';

class HeaderComponent extends Component {
    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div className="container">
                            <a href="http://localhost:3000/" className="navbar-brand">
                                <img src={"./assets/images/pawherologo.png"} height="50" alt="Paw Hero's Logo" />
                            </a>
                        </div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;