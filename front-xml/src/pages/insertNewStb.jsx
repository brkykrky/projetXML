import React, { useState } from 'react';
import { useFormik ,Formik} from 'formik';
import * as Yup from 'yup';
import {
  TextField ,
  Button,
  Select,
  MenuItem,
  Container,
  Typography,
  Grid,
  FormControl,
  InputLabel,
} from '@mui/material';
import Box from '@mui/material/Box';
import { genders } from '../utils/constants';
import {FormFeature , FormMemebers , PersonForm  , Features} from "../components/componentsInsertForm"

/*******************************************************/
/*******************************************************/
/*******************************************************/

function convertObjectToXml(obj) {
    /**DIDN'T FIND A LIBRARY */
    let xml = '';
  
    for (let key in obj) {
      if (obj.hasOwnProperty(key)) {
        if (typeof obj[key] === 'object') { // OBJECT THEN MAKE RECURSIF CALL
          xml += `<${key}>${convertObjectToXml(obj[key])}</${key}>`;
        } else {
          xml += `<${key}>${obj[key]}</${key}>`;
        }
      }
    }
  
    return xml;
  }

  






/*******************************************************/
/********************THE MAIN COMPONENT *****************************/
/*******************************************************/
const InsertNewStb = () => { 
  const validationSchema = Yup.object({
    title: Yup.string().required('Le titre est requis').max(128, 'Le titre ne doit pas dépasser 128 caractères'),
    version: Yup.number().required('La version est requise').positive('La version doit être un nombre positif'),
    date: Yup.date().required('La date de validation est requise'),
    description: Yup.string()
      .required('La description est requise')
      .max(128, 'La description ne doit pas dépasser 128 caractères'),
    client: Yup.object({
      entity: Yup.string().required("Le nom de l'entité du client est requis").max(32, "Le nom de l'entité du client ne doit pas dépasser 32 caractères"),
      person: Yup.string().required('Le nom de l\'interlocuteur est requis').max(32, 'Le nom de l\'interlocuteur ne doit pas dépasser 32 caractères'),
      mail: Yup.string().email('Adresse e-mail invalide'),
      tel: Yup.string().matches(/^\d+$/, 'Numéro de téléphone invalide'),
    }),
  });

  const initialValues = {
    title: '',
    version: '',
    date: '',
    description: '',
    client: {
      entity: '',
      person: '',
      mail: '',
      tel: '',
    },
    team: {
      member1: {
        person: '',
        mail: '',
        function: '',
      },
      member2: {
        person: '',
        mail: '',
        function: '',
      },
    },
  };

  const formik = useFormik({
    initialValues,
    validationSchema,
    onSubmit: (values) => {
      // Gérer la soumission des données
      console.log(values);
    },
  });
 
  const [numberMemeber, setNumberMember] = useState(2);
  const [nbrfeatures, setNbrFeatures] = useState(1);

  const handleClickNumberMember = (e) => {
    setNumberMember((prev) => e.target.value);
  };

  const handleClickNbrFeature = (e) => {
    setNbrFeatures(prev => nbrfeatures+1)
  }

  return (
    <Container>
      <Box p={2} mb={2} bgcolor="lightgray">
        <Typography>Informations générale de la STB</Typography>
        <Grid container display="flex" flexDirection="row" spacing={2} alignItems="center" mb={2}>
          
          <Grid item xs={3}>
            <TextField fullWidth size='small' name="title" label="Title" />
          </Grid>  

          <Grid item xs={3}>
          <TextField fullWidth size='small' name="version" label="Version" />
          </Grid> 

          <Grid item xs={3}>
          <TextField fullWidth size='small' name="date" label="Date" /> 
          </Grid> 

          <Grid item xs={6}>
            <TextField fullWidth size='small' multiline name="description" label="description" />
          </Grid> 
  
        </Grid>
       
      </Box>

      <Box p={2} mb={2} bgcolor="lightgray">
        <Box marginBottom={2}>

        <Typography>Client</Typography>
        <TextField size='small' label="Entity" name="client.entity" />
        </Box>
     
        
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


      </Box>

      <Box p={2} mb={2} bgcolor="lightgray">
        <Typography>Team</Typography>

        <Select size="small"
          sx={{ minWidth: '100px' }}
          label="Nombre d'éléments du groupe"
          value={numberMemeber}
          onChange={handleClickNumberMember}
          name="teamSize"
        >
          {[2, 3, 4, 5, 6, 7, 8].map((item) => {
            return (
              <MenuItem value={item} key={item}>
                {item}
              </MenuItem>
            );
          })}
        </Select>
        
        <Box py={1}>
          <Typography>Members</Typography>
          <FormMemebers numberMember={numberMemeber} />
        </Box>
      </Box> 


      <Box>
        <Box sx={{ marginBottom:3, display:"flex" ,flexDirection:"row" ,alignItems:"center" , justifyContent:"start"}}>
            <Typography sx={{marginRight:2}}>Features</Typography> 
            <Button size="small" variant="contained"onClick={handleClickNbrFeature}>add new feature</Button>
        </Box>
        <Features  nbrfeatures={nbrfeatures}/>
      </Box>


      <Button type='submit' variant='contained' onSubmit={formik.handleSubmit}>
        Insert new STB
      </Button>
    </Container>
  );
};

export default InsertNewStb;
