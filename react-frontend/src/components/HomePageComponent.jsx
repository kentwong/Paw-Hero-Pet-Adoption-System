import React from 'react';
import HeroImageComponent from './layout/HeroImageComponent';
import PetCardsComponent from './pet/PetCardsComponent';

const HomePageComponent = () => {
    return (
        <div>
            <HeroImageComponent />
            <PetCardsComponent />
        </div>
    );
}

export default HomePageComponent;