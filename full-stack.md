# Green Fox Fashion Web Store

Build a webshop that people can use to order some merchandise from the Green Fox
store.

## Highlights

- It has a simple frontend which can:

  - list all the items
  - user can set the quantity of any item they want to order
  - it can display a new list with the selected items

## Database

Feel free to use the provided SQL file [for MySQL](assets/fashion-web-store-js.sql)

## Main page

The main page should render an HTML displaying the full list of clothes
(explained above)

The table should be automatically rendered by the data returned from the
`/warehouse` endpoint.

![main](assets/main-js.png)

- the **frontend** should have

  - a heading with the title of the site
  - drop-down list with all unique name options
  - drop-down list with all unique size options
  - input field to set the quantity of clothes
  - list the clothing items of the database in table
  - a GET TOTAL button which displays the total amount ordered by the user

### Ordering the items

If the `/check` endpoint returns OK, then display a message under the heading
that the items can be ordered at the returned price OR display the error message
in the `result` key.

#### Styling

Add green background to the message if the cloths can be ordered and red if
there were an error.

## Endpoints

### GET `/warehouse`

Return all rows in the `warehouse` SQL table:

```json
{
    "result": "ok",
    "clothes":
    [
        {
            "id": "21",
            "item_name": "Strecth Steamed Pencil Skirt",
            "manufacturer": "Calvin Klein",
            "category": "skirts",
            "size": "s",
            "unit_price": 39.0,
        },
        {
            "id": "24",
            "item_name": "Strecth Steamed Pencil Skirt",
            "manufacturer": "Calvin Klein",
            "category": "skirts",
            "size": "m",
            "unit_price": 39.0,
        },
    ]
}
```

### GET `/price-check/?item=[string]&size=s&quantity=[integer]`

- Item is the value of the `item_name` column

- The size query string parameter identifies the size of the item

- The quantity query string parameter is used to check the availability of the
  item by the given amount

In the `warehouse` database table the `in_store` column stores how many items
are available.

Return the following JSON if the quantity is larger than 3:

```json
{
    "result": "ok",
    "total_price": "390"
}
```

Return the following JSON if the quantity is larger than available:

```json
{
    "result": "error, we don't have enough items in store"
}
```

Return the following JSON if the quantity is smaller than 3:

```json
{
    "result": "please order at least 3, one for yourself, two for your friends"
}
```

## Question

Given the following table named `applicants`.

| id | name               | country_id | age |
|:---|:-------------------|:-----------|:----|
| 1  | Bořivoj Souček     | 1          | 24  |
| 2  | Papp Patrícia      | 2          | 33  |
| 3  | Kocsis Ivett       | 2          | 37  |
| 4  | Slavomír Vykukal   | 1          | 20  |
| 5  | Bruno Malík        | 1          | 31  |
| 6  | Veronika Lukešová  | 1          | 18  |
| 7  | Székely Miklós     | 2          | 29  |
| 8  | Hegedüs Benjámin   | 2          | 37  |
| 9  | Nela Machová       | 1          | 20  |
| 10 | Balog Rajmund      | 2          | 39  |
| 11 | Major Borbála      | 2          | 35  |
| 12 | Evelína Horváthová | 1          | 23  |
| 13 | Vászoly Vivien     | 2          | 40  |
| 14 | Lada Stýskalová    | 1          | 27  |
| 15 | Dagmar Benešová    | 1          | 33  |

Given the following table named `countries`.

| id | country        |
|:---|:---------------|
| 1  | Czech Republic |
| 2  | Hungary        |


`1.` Write SQL query to insert a new applicant

  ```sql

  ```

`2.` Write SQL query that will return the youngest applicant's name

  ```sql

  ```

`3.` Write SQL query to update the `Czech Republic` country to `Czech Republic or Slovakia`

  ```sql

  ```

`4.` Write SQL query to select the name and the country of applicants from
Hungary with the age 40.

  ```sql

  ```
