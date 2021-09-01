import React, { Component } from 'react';
import UserService from '../../services/UserService';

class UpdateUserComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            userId: this.props.match.params.id,
            emailAddress: '',
            firstName: '',
            lastName: '',
            password: '',
            phone: ''
        }
        this.handleOnChange = this.handleOnChange.bind(this);
        this.updateUser = this.updateUser.bind(this);
    }

    handleOnChange = e => {
        const { id, value } = e.target;
        this.setState({
            [id]: value
        })
    }

    cancel() {
        this.props.history.push('/users');
    }

    componentDidMount() {
        UserService.getUserById(this.state.userId).then(res => {
            let user = res.data;
            this.setState({
                emailAddress: user.emailAddress,
                firstName: user.firstName,
                lastName: user.lastName,
                password: user.password,
                phone: user.phone
            })
        })
    }

    updateUser = e => {
        e.preventDefault();

        let user = {
            emailAddress: this.state.emailAddress,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            password: this.state.password,
            phone: this.state.phone
        };
        console.log(JSON.stringify((user)));

        UserService.updateUser(user, this.state.userId).then(res => {
            this.props.history.push('/users');
        });
    }

    render() {
        return (
            <div className="container">
                <form className="custom-container" onSubmit={this.updateUser}>
                    <h2 className="mb-5">Update User Details</h2>
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

                    <button type="submit" className="btn btn-success me-2">Save</button>
                    <button className="btn btn-danger" onClick={this.cancel.bind(this)}>Cancel</button>
                </form>
            </div>
        );
    }
}

export default UpdateUserComponent;