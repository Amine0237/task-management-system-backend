import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: 'd2ee529c-0740-449c-894a-5327d6958466',
};

export const sampleWithPartialData: IAuthority = {
  name: '3622d7a2-3d8b-4922-aa2d-20fa1cd6c8dd',
};

export const sampleWithFullData: IAuthority = {
  name: '457e72de-3813-4f39-a75d-ab4e34bdd995',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
