package grevi.msx.moviecatalogg.ui

import android.content.Context
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import grevi.msx.moviecatalogg.R

class SectionPagerAdapter(private val mContext : Context, fragmentManager: FragmentManager)  : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    @StringRes
    private val TAB_TITLES = intArrayOf(R.string.tab_name_1, R.string.tab_name_2)

    override fun getItem(position: Int): Fragment {
        var fragments : Fragment? = null
        when(position) {
            0 -> fragments = MoviesFragments()
            1 -> fragments =  TvShowFragments()
        }
        return fragments as Fragment
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }

}