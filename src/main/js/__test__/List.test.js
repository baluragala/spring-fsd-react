import { render, screen } from '@testing-library/react';
import List from '../components/List';

test('renders the List component', () => {
    const chocolates = []
    render(<List chocolates={chocolates} />);
});

test('renders the List component with 3 chocolates', () => {
    const chocolates= [
        {
            id: 1,
            name: "Diary Milk",
            brand: "Cadbury",
            size: "small",
            price: "5",
            soh: 10
        },
        {
            id: 2,
            name: "5 Star",
            brand: "Cadbury",
            size: "small",
            price: "5",
            soh: 10
        },
        {
            id: 3,
            name: "KitKat",
            brand: "Nestle",
            size: "small",
            price: "8",
            soh: 4
        }
    ]
    const {  getByTestId }  = render(<List chocolates={chocolates} />);
    const list = getByTestId("choco-list");
    expect(list.children[1].children.length).toBe(3)
});

