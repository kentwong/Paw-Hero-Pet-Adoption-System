import React, { Component } from 'react';
import PawHeroLogo from '../assets/images/pawherologo.png';

class HeaderComponent extends Component {
    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div className="px-4">
                            <a href="http://localhost:3000/" className="navbar-brand">
                                <img src={PawHeroLogo} height="50" alt="Paw Hero's Logo" />
                            </a>
                        </div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;