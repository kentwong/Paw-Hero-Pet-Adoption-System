import React, { Component } from 'react';

class HeroImageComponent extends Component {
    render() {
        return (
            <div className="jumbotron jumbotron-fluid">
                <div className="container jumbotron-content">
                    <h1 className="display-4">Fluid jumbotron</h1>
                    <p>This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
                </div>
            </div>
        );
    }
}

export default HeroImageComponent;