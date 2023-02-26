class FittingRepositoryFake : FittingRepository {
    override suspend fun swiper(): List<String> {
        return listOf(
            "https://i0.hdslb.com/bfs/banner/1172479ab9bbefeb635410c70bacc612e084dd01.png@976w_550h_1c_!web-home-carousel-cover.webp",
            "https://i0.hdslb.com/bfs/banner/6fdaf1be9d0a56934d57cf4aefe02dbf5cf47322.png@976w_550h_1c_!web-home-carousel-cover.webp",
            "https://i0.hdslb.com/bfs/banner/f68b3002806435cea99f3d9403fc94c80bc4c3c9.png@976w_550h_1c_!web-home-carousel-cover.webp"
        )
    }
}