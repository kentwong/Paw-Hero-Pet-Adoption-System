import React, { Component } from 'react';
import PetService from '../services/PetService';

class ListPetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            pets: []
        }
    }

    componentDidMount() {
        PetService.getPets().then((res) => {
            this.setState({ pets: res.data })
        })
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Pets List</h2>
                <div className="row">
                    <table className="table table-Striped table-bordered">
                        <thead>
                            <tr>
                                <th>Pet Name</th>
                                <th>Pet Age</th>
                                <th>Pet Description</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.pets.map(
                                    pet =>
                                        <tr key={pet.id}>
                                            <td> {pet.name} </td>
                                            <td> {pet.age} </td>
                                            <td> {pet.description} </td>
                                        </tr>
                                )
                            }
                        </tbody>

                    </table>
                </div>
            </div>
        );
    }
}

export default ListPetComponent;