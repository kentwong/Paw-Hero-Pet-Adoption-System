import axios from 'axios';

const PET_API_BASE_URL = "http://localhost:8081/pawhero/application";

class ApplicationService {
    getPets() {
        return axios.get(PET_API_BASE_URL);
    }

    createApplication(pet) {
        return axios.post(PET_API_BASE_URL, pet);
    }

    getPetById(petId) {
        return axios.get(PET_API_BASE_URL + '/' + petId);
    }

    updatePet(pet, petId) {
        return axios.put(PET_API_BASE_URL + '/' + petId, pet);
    }

    deletePet(petId) {
        return axios.delete(PET_API_BASE_URL + '/' + petId);
    }

}

export default new ApplicationService();