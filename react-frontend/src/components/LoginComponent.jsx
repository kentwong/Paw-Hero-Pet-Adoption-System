import React, { Component } from 'react';
import { connect } from 'react-redux';
import { authenticateUser } from '../services/index'

class LoginComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            emailAddress: '',
            password: ''
        }
        this.handleOnChange = this.handleOnChange.bind(this);
        this.validateUser = this.validateUser.bind(this);
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

    validateUser = e => {
        e.preventDefault();

        this.props.authenticateUser(this.state.emailAddress, this.state.password)
        // let user = {
        //     emailAddress: this.state.emailAddress,
        //     password: this.state.password
        // };
        // console.log(JSON.stringify(user));

        // PetService.createPet(pet).then(res => {
        //     this.props.history.push('/pets');
        // });
    }

    render() {
        return (
            <div className="container">
                <form className="custom-container" onSubmit={this.validateUser}>
                    <h2 className="mb-5">Log In</h2>

                    <div className="mb-3">
                        <label htmlFor="emailAddress" className="form-label">Email Address <span className="text-danger">*</span></label>
                        <input type="text" className="form-control" id="emailAddress" value={this.state.emailAddress} onChange={this.handleOnChange} required></input>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="password" className="form-label">Password <span className="text-danger">*</span></label>
                        <input type="password" className="form-control" id="password" value={this.state.password} onChange={this.handleOnChange} required></input>
                    </div>

                    <button type="submit" className="btn btn-success me-2">Login</button>
                    <button className="btn btn-danger" onClick={this.cancel.bind(this)}>Cancel</button>
                </form>
            </div>
        );
    }
}

const mapStateToProps = state => {
    return {
        login: state.login
    }
}

const mapDispatchToProps = dispatch => {
    return {
        authenticateUser: (emailAddress, password) => dispatch(authenticateUser(emailAddress, password))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(LoginComponent);