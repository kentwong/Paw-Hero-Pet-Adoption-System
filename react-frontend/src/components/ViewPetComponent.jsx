import React, { Component } from 'react';
import PetService from '../services/PetService';

class ViewPetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            petId: this.props.match.params.id,
            type: 'dog',
            name: '',
            breed: '',
            ageMonth: '',
            ageYear: '',
            sex: 'male',
            location: '',
            adoptionFee: '',
            description: '',
            imageUrl: ''
        }
    }

    cancel() {
        this.props.history.push('/pets');
    }

    componentDidMount() {
        PetService.getPetById(this.state.petId).then(res => {
            let pet = res.data;
            this.setState({
                type: pet.type,
                name: pet.name,
                breed: pet.breed,
                ageMonth: pet.age.split(' ')[2],
                ageYear: pet.age.split(' ')[0],
                sex: pet.sex,
                location: pet.location,
                adoptionFee: pet.adoptionFee,
                description: pet.description,
                imageUrl: pet.imageUrl
            })
        })
    }

    render() {
        return (
            <div>
                <h1>Pet Details</h1>
                <h1>{this.state.name}</h1>

            </div>
        );
    }
}

export default ViewPetComponent;