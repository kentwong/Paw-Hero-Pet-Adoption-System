import React, { Component } from 'react';
import PetService from '../services/PetService';

class ListPetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            pets: []
        }

        this.addPet = this.addPet.bind(this);
        this.updatePet = this.updatePet.bind(this);
    }

    componentDidMount() {
        PetService.getPets().then((res) => {
            this.setState({ pets: res.data })
        })
    }

    addPet() {
        this.props.history.push('/addpet');
    }

    updatePet(id) {
        this.props.history.push(`/updatepet/${id}`);
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Pets List</h2>
                <div className="row">
                    <button className="btn btn-primary col-2" onClick={this.addPet}>Add Pet</button>
                </div>
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
                                        <tr key={pet.petId}>
                                            <td> {pet.name} </td>
                                            <td> {pet.age} </td>
                                            <td> {pet.description} </td>
                                            <td>
                                                <button onClick={() => this.updatePet(pet.petId)} className="btn btn-primary">Update</button>
                                            </td>
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