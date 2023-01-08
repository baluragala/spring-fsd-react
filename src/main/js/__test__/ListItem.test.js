import { render, screen } from '@testing-library/react';
import Item from '../components/ListItem';

test('renders the Item component', () => {
    const item = {
            id: 1,
            name: "Diary Milk",
            brand: "Cadbury",
            size: "small",
            price: "5",
            soh: 10
        }
    render(<Item item={item} title={"Sell"}/>);
});

test('Item should render sell button if soh > 0', () => {
    const item = {
        id: 1,
        name: "Diary Milk",
        brand: "Cadbury",
        size: "small",
        price: "5",
        soh: 10
    }
    const {getByRole} = render(<Item item={item} title={"Sell"}/>);
    expect(getByRole("button")).not.toBeNull()
});
