import { render, screen } from '@testing-library/react';
import Employee from '../components/Employee';

test('renders the Employee component', () => {
    const employee = {firstName:'John', lastName:"Doe", description:"Good Employee"}
    render(<Employee employee={employee} />);
});