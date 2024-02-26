import React from "react";
import { Navbar, Container } from "react-bootstrap";

function MenuHeadersExample() {
  return (
    <>
      <Navbar
        bg="dark"
        variant="dark"
        sticky="top"
        style={{ marginBottom: "20px" }}
      >
        <Container>
          <Navbar.Brand href="/list-todo">
            <h2>Todo-List Application 待办事项列表</h2>
          </Navbar.Brand>
        </Container>
      </Navbar>
    </>
  );
}

export default MenuHeadersExample;
