package com.example.artomap.ui.map

//import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.artomap.databinding.FragmentMapBinding
import org.osmdroid.config.Configuration
import org.osmdroid.library.BuildConfig
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView


class MapFragment : Fragment() {

    lateinit var binding: FragmentMapBinding

    lateinit var map : MapView




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentMapBinding.inflate(inflater, container, false)
        map = binding.map


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        map.setTileSource(TileSourceFactory.MAPNIK) // Example: using Mapnik tiles
        map.setBuiltInZoomControls(false)
        map.setMultiTouchControls(true)


        // Set initial center and zoom
        map.getController().setZoom(14.0)
        map.getController().setCenter(GeoPoint(42.848522, 74.583859)) // Example: London coordinates


        // Important for configuration, especially for caching
        Configuration.getInstance().setUserAgentValue(BuildConfig.BUILD_TYPE)


    }


}