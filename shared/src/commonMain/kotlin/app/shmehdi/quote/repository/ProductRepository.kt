//package shmehdi.app.estore.repository
//
//import app.shmehdi.quote.repository.BaseRepository
//import kotlinx.coroutines.flow.flow
//import shmehdi.app.estore.models.Product
//import app.shmehdi.quote.utils.CommonFlow
//import app.shmehdi.quote.utils.asCommonFlow
//import shmehdi.app.estore.vo.Resource
//
//class ProductRepository: BaseRepository() {
//
//    suspend fun fetchProducts(category: String? = null): CommonFlow<Resource<List<Product>>> = flow {
//        emit(Resource.loading())
//        emit(apiService.fetchProducts(category = category).toResource())
//    }.asCommonFlow()
//
//    suspend fun fetchCategories(): CommonFlow<Resource<List<String>>> = flow {
//        emit(Resource.loading())
//        emit(apiService.fetchCategories().toResource())
//    }.asCommonFlow()
//}