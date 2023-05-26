/*****THIS FILE CONTAINES THE DIFFERENTS SUB COMPONENTS USED FOR THE INSERT FORM */
import {
  TextField ,
  Select,
  MenuItem,
  Grid,
  FormControl,
  Box,
  InputLabel,
} from '@mui/material';
import { genders } from '../utils/constants';

export const PersonForm = () => {
  return (
    <>
      <Grid display="flex" flexDirection="row" columnGap={2}  alignItems="center" >
        <TextField size="small"  name="firstName" label="First Name" />
        <TextField size="small"  name="lastName" label="Last Name" />
        <Select size='small' sx={{ minWidth: '100px' }} label="Gender" value={'Mr'} name="gender">
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
      <Box my={1} display="flex" columnGap={2} alignItems="center">
        <PersonForm key={i} />
        <TextField size="small"  label={'fonctionnalité'} name={`function-${i}`} /> 
        <TextField size="small"  label={'Email'} name={`email-${i}`} />

      </Box>
    );
  }
  return memberForms;
};


export const  FormFeature = () => {
        return (
        <Grid p={1} bgcolor={"lightgray"} container columnSpacing={2} rowSpacing={2} mb={2}>    
          <Grid item container spacing={2} >
            <Grid item xs={6}> 
            <TextField size="small"  label="Nom" variant="outlined" fullWidth /> 
            </Grid>
            <Grid item xs={6}> 
            <TextField size="small"  label="Section" variant="outlined" fullWidth />
          </Grid>
      </Grid>

      <Grid item container columnSpacing={2} rowSpacing={2}>
        <Grid item xs={4}> 
        <TextField size="small"  label="Numéro" variant="outlined" type="number" fullWidth />
        </Grid>
        <Grid item xs={8}> 
        <TextField size="small"  label="Description" variant="outlined" fullWidth multiline maxRows={4} />
        </Grid>
      </Grid>
        
     
      <Grid item container spacing={2} >
        <Grid item xs={2}> 
          <FormControl fullWidth>
          <InputLabel>Niveau de priorité</InputLabel>
          <Select size='small' sx={{ minWidth: '50px' }} label="Priorité" value={1}>
            { [1,2,3,4,5,6,7,8,9,10].map(i=><MenuItem value={i}>{i}</MenuItem>)}
          </Select>
        </FormControl>    
          </Grid>
        <Grid item xs={4}> 
        <TextField size="small"  label="Date de livraison" variant="outlined" type="date" fullWidth />
        </Grid>
        <Grid item xs={6}>
        <TextField size="small"  label="Commentaires" variant="outlined" fullWidth multiline maxRows={4} />
        </Grid>
      </Grid>
     
    

        </Grid>
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

