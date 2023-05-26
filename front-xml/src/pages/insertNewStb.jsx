import React, { useState } from 'react';
import { useFormik ,Formik} from 'formik';
import * as Yup from 'yup';
import {
  TextField,
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
        <Grid display="flex" flexDirection="row" spacing={2} alignItems="center" mb={2}>
          <TextField name="title" label="Title" />
          <TextField name="version" label="Version" />
          <TextField name="date" label="Date" />
        </Grid>
        <TextField multiline name="description" />
      </Box>

      <Box p={2} mb={2} bgcolor="lightgray">
        <Typography>Client</Typography>
        <TextField label="Entity" name="client.entity" />

        <Grid display="flex" flexDirection="row" spacing={2} alignItems="center" mb={2}>
          <TextField name="client.person" />
          <TextField name="client.mail" />
        </Grid>
      </Box>

      <Box p={2} mb={2} bgcolor="lightgray">
        <Typography>Team</Typography>

        <Select
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

        <Grid display="flex" flexDirection="row" spacing={2} alignItems="center" mb={2}>
          <TextField name="team.member1.person" />
          <TextField name="team.member1.mail" />
        </Grid>
      </Box> 


      <Box>
        <Box>
            <Typography>Features</Typography> 
            <Button onClick={handleClickNbrFeature}>add new feature</Button>
        </Box>
        <Features  nbrfeatures={nbrfeatures}/>
      </Box>


      <Button type='submit' onSubmit={formik.handleSubmit}>
        Send nude 
      </Button>
    </Container>
  );
};

export default InsertNewStb;
