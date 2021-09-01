import React, { Component } from 'react';
import UserService from '../services/UserService';

class ListUserComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            users: []
        }
        this.updateUser = this.updateUser.bind(this);
        this.deleteUser = this.deleteUser.bind(this);
    }

    componentDidMount() {
        UserService.getUsers().then((res) => {
            this.setState({ users: res.data })
        })
    }

    updateUser(id) {
        this.props.history.push(`/updateuser/${id}`);
    }

    deleteUser(id) {
        UserService.deleteUser(id);
        this.setState({ users: this.state.users.filter(user => user.userId !== id) })
    }

    render() {
        return (
            <div className="container my-5">
                <h2 className="text-center">User List</h2>

                <div className="row">
                    <table className="table table-Striped table-bordered">
                        <thead>
                            <tr>
                                <th className="w-10">User ID</th>
                                <th className="w-10">Name</th>
                                <th className="w-55">Email Address</th>
                                <th className="w-55">Phone Number</th>
                                <th className="w-25">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.users.map(
                                    user =>
                                        <tr key={user.userId}>
                                            <td> {user.userId} </td>
                                            <td> {user.firstName + ' ' + user.lastName} </td>
                                            <td> {user.emailAddress} </td>
                                            <td> {user.phone} </td>
                                            <td>
                                                <button onClick={() => this.updateUser(user.userId)} className="btn btn-primary mb-2 me-2">Update</button>
                                                <button onClick={() => this.deleteUser(user.userId)} className="btn btn-danger mb-2 me-2">Delete</button>
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>

                    </table>
                </div>
                {/* <div className="">
                    <button className="btn btn-success" onClick={this.addPet}>Add Pet</button>
                </div> */}
            </div>
        );
    }
}

export default ListUserComponent;