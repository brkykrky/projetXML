/*****THIS FILE CONTAINES THE DIFFERENTS SUB COMPONENTS USED FOR THE INSERT FORM */
import {
  TextField,
  Select,
  MenuItem,
  Grid,
  FormControl,
  InputLabel,
} from '@mui/material';
import { genders } from '../utils/constants';

export const PersonForm = () => {
  return (
    <>
      <Grid display="flex" flexDirection="row" spacing={2} alignItems="center" >
        <TextField name="firstName" label="First Name" />
        <TextField name="lastName" label="Last Name" />
        <Select sx={{ minWidth: '100px' }} label="Gender" value={'Mr'} name="gender">
          {genders.map((gender) => {
            return (
              <MenuItem value={gender} key={gender}>
                {gender}
              </MenuItem>
            );
          })}
        </Select>
      </Grid>
    </>
  );
};

export const  FormMemebers = ({ numberMember }) => {
  const memberForms = [];
  for (let i = 0; i < numberMember; i++) {
    memberForms.push(
      <>
        <PersonForm key={i} />
        <TextField label={'fonctionnalité'} name={`function-${i}`} />
      </>
    );
  }
  return memberForms;
};


export const  FormFeature = () => {
        return (<>
      <TextField label="Nom" variant="outlined" fullWidth />
      <TextField label="Section" variant="outlined" fullWidth />
      <TextField label="Numéro" variant="outlined" type="number" fullWidth />
      <TextField label="Description" variant="outlined" fullWidth multiline maxRows={4} />
      <FormControl fullWidth>
        <InputLabel>Niveau de priorité</InputLabel>
        <Select sx={{ minWidth: '50px' }} label="Priorité" value={1}>
           { [1,2,3,4,5,6,7,8,9,10].map(i=><MenuItem value={i}>{i}</MenuItem>)}
        </Select>
      </FormControl>
      <TextField label="Date de livraison" variant="outlined" type="date" fullWidth />
      <TextField label="Commentaires" variant="outlined" fullWidth multiline maxRows={4} />

        </>
        )
};

export const Features = ({nbrfeatures}) => {
    const FeaturesList = [];
    for (let i = 0; i < nbrfeatures; i++) {
        FeaturesList.push(
        <>
        <FormFeature />
        </>
      );
    }
    return FeaturesList;
}

