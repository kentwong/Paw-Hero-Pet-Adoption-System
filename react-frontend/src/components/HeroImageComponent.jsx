import React, { Component } from 'react';

class HeroImageComponent extends Component {
    render() {
        return (
            <div class="jumbotron jumbotron-fluid" style={{ backgroundImage: `url("./assets/images/dogandcat.jpg")` }}>
                <div class="container jumbotron-content">
                    <h1 class="display-4">Fluid jumbotron</h1>
                    <p>This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
                </div>
            </div>
        );
    }
}

export default HeroImageComponent;