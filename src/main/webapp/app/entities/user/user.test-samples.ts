import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 16574,
  login: 'GQMV',
};

export const sampleWithPartialData: IUser = {
  id: 32476,
  login: 'bE7',
};

export const sampleWithFullData: IUser = {
  id: 19199,
  login: 'n_@8SX5l1\\jQ',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
