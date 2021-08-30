import axios from 'axios';

const PET_API_BASE_URL = "http://localhost:8081/pawhero/api/v1/pets";

class PetService {
    getPets() {
        return axios.get(PET_API_BASE_URL);
    }

    createPet(pet) {
        return axios.post(PET_API_BASE_URL, pet);
    }

    getPetById(petId) {
        return axios.get(PET_API_BASE_URL + '/' + petId);
    }

    updatePet(pet, petId) {
        return axios.put(PET_API_BASE_URL + '/' + petId, pet);
    }

}

export default new PetService();