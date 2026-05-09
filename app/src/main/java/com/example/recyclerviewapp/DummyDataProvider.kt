package com.example.recyclerviewapp

/**
 * Generates a list of dummy [Item] objects.
 * The default count is 150 which satisfies the request for 100‑200 items.
 */
fun generateDummyItems(count: Int = 150): List<Item> {
    val images = listOf(
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher_round
    )
    return List(count) { index ->
        val id = (index + 1).toLong()
        Item(
            id = id,
            title = "Item #$id",
            description = "This is a description for item #$id. It is generated for demo purposes.",
            imageRes = images[index % images.size]
        )
    }
}
