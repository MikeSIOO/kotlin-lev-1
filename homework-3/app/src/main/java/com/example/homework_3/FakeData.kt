package com.example.homework_3

import kotlinx.coroutines.delay

class SearchResult(val searchElements: ArrayList<SearchElement> = arrayListOf()) {
    class SearchElement(
        val name: String,
        val time: String,
        val image: Int,
        val tags: ArrayList<String>
    )

    companion object {
        private val searchResult: ArrayList<SearchElement> = arrayListOf(
            SearchElement(
                "Омлет",
                "30 минут",
                R.drawable.first,
                arrayListOf("Завтрак", "Легко приготовить")
            ),
            SearchElement(
                "Омлет получше",
                "20 минут",
                R.drawable.second,
                arrayListOf("Обед", "Легко приготовить", "Веганский")
            ),
            SearchElement(
                "Омлет мечты",
                "10 минут",
                R.drawable.third,
                arrayListOf("Перекус", "Легко приготовить")
            )
        )

        suspend fun getSearchById(id: Int): SearchElement {
            delay(500L)
            return searchResult[id % 3]
        }
    }
}

class FullRecipe(val recipeElements: ArrayList<RecipeElement>) {
    class RecipeElement(
        val name: String,
        val time: String,
        val image: Int,
        val ingredients: ArrayList<Ingredients>,
        val steps: ArrayList<Step>
    ) {
        class Ingredients(
            val name: String,
            val quantity: String
        )

        class Step(
            val id: String,
            val image: Int,
            val description: String
        )
    }

    companion object {
        private val recipes: ArrayList<RecipeElement> = arrayListOf(
            RecipeElement(
                "Омлет",
                "30 минут",
                R.drawable.first,
                arrayListOf(
                    RecipeElement.Ingredients("Яйца", "2 шт"),
                    RecipeElement.Ingredients("Помидор", "1 шт"),
                    RecipeElement.Ingredients("Молоко", "100 мл"),
                ),
                arrayListOf(
                    RecipeElement.Step(
                        "1",
                        R.drawable.first,
                        "Нужно сделать то-то и то-то, а потом еще вот это"
                    ),
                    RecipeElement.Step(
                        "2",
                        R.drawable.second,
                        "Нужно сделать то-то и то-то, а потом еще вот это"
                    ),
                    RecipeElement.Step(
                        "3",
                        R.drawable.third,
                        "Нужно сделать то-то и то-то, а потом еще вот это"
                    ),
                    RecipeElement.Step(
                        "4",
                        R.drawable.first,
                        "Нужно сделать то-то и то-то, а потом еще вот это"
                    )
                )
            ),
            RecipeElement(
                "Омлет получше",
                "20 минут",
                R.drawable.first,
                arrayListOf(
                    RecipeElement.Ingredients("Яйца", "2 шт"),
                    RecipeElement.Ingredients("Помидор", "1 шт"),
                    RecipeElement.Ingredients("Молоко", "100 мл"),
                ),
                arrayListOf(
                    RecipeElement.Step(
                        "1",
                        R.drawable.first,
                        "Нужно сделать то-то и то-то, а потом еще вот это"
                    ),
                    RecipeElement.Step(
                        "2",
                        R.drawable.second,
                        "Нужно сделать то-то и то-то, а потом еще вот это"
                    ),
                    RecipeElement.Step(
                        "3",
                        R.drawable.third,
                        "Нужно сделать то-то и то-то, а потом еще вот это"
                    ),
                    RecipeElement.Step(
                        "4",
                        R.drawable.first,
                        "Нужно сделать то-то и то-то, а потом еще вот это"
                    )
                )
            ),
            RecipeElement(
                "Омлет мечты",
                "10 минут",
                R.drawable.first,
                arrayListOf(
                    RecipeElement.Ingredients("Яйца", "2 шт"),
                    RecipeElement.Ingredients("Помидор", "1 шт"),
                    RecipeElement.Ingredients("Молоко", "100 мл"),
                ),
                arrayListOf(
                    RecipeElement.Step(
                        "1",
                        R.drawable.first,
                        "Нужно сделать то-то и то-то, а потом еще вот это"
                    ),
                    RecipeElement.Step(
                        "2",
                        R.drawable.second,
                        "Нужно сделать то-то и то-то, а потом еще вот это"
                    ),
                    RecipeElement.Step(
                        "3",
                        R.drawable.third,
                        "Нужно сделать то-то и то-то, а потом еще вот это"
                    ),
                    RecipeElement.Step(
                        "4",
                        R.drawable.first,
                        "Нужно сделать то-то и то-то, а потом еще вот это"
                    )
                )
            ),
        )

        suspend fun getRecipe(id: Int): RecipeElement {
            delay(500L)
            return recipes[id]
        }
    }
}

class ProductCategories(val categories: ArrayList<Category>) {
    class Category(
        val name: String,
        val categoryElements: ArrayList<String>
    )

    companion object {
        private val products: ArrayList<Category> = arrayListOf(
            Category(
                "Молоко, молочные продукты",
                arrayListOf(
                    "Молоко",
                    "Сливки",
                    "Кефир",
                    "Йогурт",
                    "Творог",
                    "Сметана",
                    "Сливочное масло",
                    "Сгущенка"
                )
            ),
            Category(
                "Мясо",
                arrayListOf(
                    "Говядина",
                    "Свинина",
                    "Крольчатина",
                    "Курица",
                    "Индейка",
                    "Утка",
                    "Растительное мясо"
                )
            ),
            Category(
                "Сыры",
                arrayListOf(
                    "Пармезан",
                    "Сливочный",
                    "Российский",
                    "Легкий",
                    "Страчателла",
                    "Бри",
                    "Моцарелла"
                )
            ),
            Category(
                "Мясная гастрономия",
                arrayListOf(
                    "Вареная",
                    "Докторская",
                    "Охотничья",
                    "Ветчина",
                    "Сосиски",
                    "Сардельки",
                    "Бекон"
                )
            ),
            Category(
                "Овощи и фрукт",
                arrayListOf(
                    "Помидоры",
                    "Огурцы",
                    "Сладкий перец",
                    "Перец чили",
                    "Авокадо",
                    "Бананы",
                    "Яблоки"
                )
            ),
            Category(
                "Молоко, молочные продукты",
                arrayListOf(
                    "Молоко",
                    "Сливки",
                    "Кефир",
                    "Йогурт",
                    "Творог",
                    "Сметана",
                    "Сливочное масло",
                    "Сгущенка"
                )
            ),
            Category(
                "Мясо",
                arrayListOf(
                    "Говядина",
                    "Свинина",
                    "Крольчатина",
                    "Курица",
                    "Индейка",
                    "Утка",
                    "Растительное мясо"
                )
            ),
            Category(
                "Сыры",
                arrayListOf(
                    "Пармезан",
                    "Сливочный",
                    "Российский",
                    "Легкий",
                    "Страчателла",
                    "Бри",
                    "Моцарелла"
                )
            ),
            Category(
                "Мясная гастрономия",
                arrayListOf(
                    "Вареная",
                    "Докторская",
                    "Охотничья",
                    "Ветчина",
                    "Сосиски",
                    "Сардельки",
                    "Бекон"
                )
            ),
            Category(
                "Овощи и фрукт",
                arrayListOf(
                    "Помидоры",
                    "Огурцы",
                    "Сладкий перец",
                    "Перец чили",
                    "Авокадо",
                    "Бананы",
                    "Яблоки"
                )
            ),
            Category(
                "Молоко, молочные продукты",
                arrayListOf(
                    "Молоко",
                    "Сливки",
                    "Кефир",
                    "Йогурт",
                    "Творог",
                    "Сметана",
                    "Сливочное масло",
                    "Сгущенка"
                )
            ),
            Category(
                "Мясо",
                arrayListOf(
                    "Говядина",
                    "Свинина",
                    "Крольчатина",
                    "Курица",
                    "Индейка",
                    "Утка",
                    "Растительное мясо"
                )
            ),
            Category(
                "Сыры",
                arrayListOf(
                    "Пармезан",
                    "Сливочный",
                    "Российский",
                    "Легкий",
                    "Страчателла",
                    "Бри",
                    "Моцарелла"
                )
            ),
            Category(
                "Мясная гастрономия",
                arrayListOf(
                    "Вареная",
                    "Докторская",
                    "Охотничья",
                    "Ветчина",
                    "Сосиски",
                    "Сардельки",
                    "Бекон"
                )
            ),
            Category(
                "Овощи и фрукт",
                arrayListOf(
                    "Помидоры",
                    "Огурцы",
                    "Сладкий перец",
                    "Перец чили",
                    "Авокадо",
                    "Бананы",
                    "Яблоки"
                )
            ),
            Category(
                "Молоко, молочные продукты",
                arrayListOf(
                    "Молоко",
                    "Сливки",
                    "Кефир",
                    "Йогурт",
                    "Творог",
                    "Сметана",
                    "Сливочное масло",
                    "Сгущенка"
                )
            ),
            Category(
                "Мясо",
                arrayListOf(
                    "Говядина",
                    "Свинина",
                    "Крольчатина",
                    "Курица",
                    "Индейка",
                    "Утка",
                    "Растительное мясо"
                )
            ),
            Category(
                "Сыры",
                arrayListOf(
                    "Пармезан",
                    "Сливочный",
                    "Российский",
                    "Легкий",
                    "Страчателла",
                    "Бри",
                    "Моцарелла"
                )
            ),
            Category(
                "Мясная гастрономия",
                arrayListOf(
                    "Вареная",
                    "Докторская",
                    "Охотничья",
                    "Ветчина",
                    "Сосиски",
                    "Сардельки",
                    "Бекон"
                )
            ),
            Category(
                "Овощи и фрукт",
                arrayListOf(
                    "Помидоры",
                    "Огурцы",
                    "Сладкий перец",
                    "Перец чили",
                    "Авокадо",
                    "Бананы",
                    "Яблоки"
                )
            ),
        )

        suspend fun getProducts(): ArrayList<Category> {
            delay(500L)
            return products
        }
    }
}


class ProfileData(val profileElements: ArrayList<ProfileElement> = arrayListOf()) {
    class ProfileElement(
        val name: String,
        val time: String,
        val image: Int,
        val tags: ArrayList<String>
    )

    companion object {
        private val profileResult: ArrayList<ProfileElement> = arrayListOf(
            ProfileElement(
                "Омлет",
                "30 минут",
                R.drawable.first,
                arrayListOf("Завтрак", "Легко приготовить")
            ),
            ProfileElement(
                "Омлет получше",
                "20 минут",
                R.drawable.second,
                arrayListOf("Обед", "Веганский")
            ),
            ProfileElement(
                "Омлет мечты",
                "10 минут",
                R.drawable.third,
                arrayListOf("Перекус", "Легко приготовить")
            ),
            ProfileElement(
                "Омлет",
                "30 минут",
                R.drawable.first,
                arrayListOf("Завтрак", "Легко приготовить")
            ),
            ProfileElement(
                "Омлет получше",
                "20 минут",
                R.drawable.second,
                arrayListOf("Обед", "Веганский")
            ),
            ProfileElement(
                "Омлет мечты",
                "10 минут",
                R.drawable.third,
                arrayListOf("Перекус", "Легко приготовить")
            ),
        )

        suspend fun getData(): ArrayList<ProfileElement> {
            delay(500L)
            return profileResult
        }
    }
}