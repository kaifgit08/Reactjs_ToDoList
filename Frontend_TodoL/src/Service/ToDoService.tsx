import axios from "axios";
//cont 
const baseUrl = "http://localhost:0802/api/todo";

export const createToDo = (todo: any) => axios.post(baseUrl, todo);

export const getAllToDo = () => axios.get(baseUrl);

export const deleteToDoById = (id: number) => axios.delete(baseUrl + "/" + id);

export const getToDoById = (id: number) => axios.get(baseUrl + "/" + id);

export const updateToDoById = (id: number, todo: any) =>
  axios.put(baseUrl + "/" + id, todo);

export const completeTodo = (id: number) =>
  axios.put(baseUrl + "/" + id + "/complete");

export const inCompleteTodo = (id: number) =>
  axios.put(baseUrl + "/" + id + "/in-complete");
