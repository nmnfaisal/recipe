package me.noman.recipes.core.di.modules;


import android.content.Context
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import me.noman.recipes.data.preferences.RecipeSharedPreferences

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun providesRecipeSharedPreferences(@ApplicationContext context: Context): RecipeSharedPreferences {
        return RecipeSharedPreferences(context)
    }

}