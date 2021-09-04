import React, { Component } from 'react';

class CreatePetUnauthorisedComponent extends Component {
    render() {
        return (
            <div className="container">
                <div class="alert alert-danger my-5" role="alert">
                    Unauthorised Access. Please leave.
                </div>
            </div>
        );
    }
}

export default CreatePetUnauthorisedComponent;