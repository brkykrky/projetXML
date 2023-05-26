import axios from "axios";

export const axiosInstanceXml = axios.create({
  baseURL: 'http://localhost:8080/', 
  headers: {
    'Content-Type': 'application/xml',
    'Accept':'application/xml', 
    'Access-Control-Allow-Origin': '*', // Autorise toutes les origines, veuillez ajuster en fonction de vos besoins de sécurité
  },
});

export const axiosInstanceHtml = axios.create({
  baseURL: 'http://localhost:8080/', 
  headers: {
    'Content-Type': 'text/html',
    'Accept':'text/html', 
    'Access-Control-Allow-Origin': '*', // Autorise toutes les origines, veuillez ajuster en fonction de vos besoins de sécurité
  },
});
