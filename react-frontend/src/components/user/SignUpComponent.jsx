import React, { Component } from 'react';
import UserService from '../../services/UserService';
import { useHistory } from 'react-router-dom';

class SignUpComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            firstName: '',
            lastName: '',
            phone: '',
            emailAddress: '',
            password: ''
        }
        this.handleOnChange = this.handleOnChange.bind(this);
        this.addUser = this.addUser.bind(this);
    }

    handleOnChange = e => {
        const { id, value } = e.target;
        this.setState({
            [id]: value
        })
    }

    cancel() {
        this.props.history.push('/');
    }

    addUser = e => {
        e.preventDefault();

        let user = {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            phone: this.state.phone,
            emailAddress: this.state.emailAddress,
            password: this.state.password,
            role: {
                "roleId": 2,
                "name": "user"
            }
        };
        console.log(JSON.stringify(user));

        UserService.createUser(user).then(res => {
            this.props.history.push('/login');
        })

    }

    render() {
        return (
            <div className="container">
                <form className="custom-container" onSubmit={this.addUser}>
                    <h2 className="mb-5">Sign Up</h2>
                    <div className="row mb-3">
                        <div className="col-md-6">
                            <label htmlFor="firstname" className="form-label">First Name <span className="text-danger">*</span></label>
                            <input type="text" className="form-control" id="firstName" value={this.state.firstName} onChange={this.handleOnChange} required></input>
                        </div>
                        <div className="col-md-6">
                            <label htmlFor="lastName" className="form-label">Last Name<span className="text-danger">*</span></label>
                            <input type="text" className="form-control" id="lastName" value={this.state.lastName} onChange={this.handleOnChange} required></input>
                        </div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="phone" className="form-label">Phone <span className="text-danger">*</span></label>
                        <input type="tel" className="form-control" id="phone" value={this.state.phone} minLength="10" onChange={this.handleOnChange} required></input>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="emailAddress" className="form-label">Email Address <span className="text-danger">*</span></label>
                        <input type="email" className="form-control" id="emailAddress" value={this.state.emailAddress} onChange={this.handleOnChange} required></input>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="password" className="form-label">Password <span className="text-danger">*</span></label>
                        <input type="password" className="form-control" id="password" value={this.state.password} onChange={this.handleOnChange} required></input>
                    </div>

                    <button type="submit" className="btn btn-success me-2">Sign Up</button>
                    <button className="btn btn-danger" onClick={this.cancel.bind(this)}>Cancel</button>
                </form>
            </div>
        );
    }
}

export default SignUpComponent;