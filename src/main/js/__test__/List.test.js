import { render, screen } from '@testing-library/react';
import List from '../components/List';

test('renders the List component', () => {
    const chocolates = []
    render(<List chocolates={chocolates} />);
});

