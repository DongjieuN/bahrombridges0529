package com.example.o_ttae.ui.taste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.o_ttae.R
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.util.FusedLocationSource

class TasteFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var naverMap: NaverMap
    private val LOCATION_PERMISSTION_REQUEST_CODE: Int = 1000
    private lateinit var locationSource: FusedLocationSource // 위치를 반환하는 구현체



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_taste, container, false)

        mapView = view.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)

        mapView.getMapAsync(this)
        locationSource = FusedLocationSource(this, LOCATION_PERMISSTION_REQUEST_CODE)
        return view
    }


    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onMapReady(map: NaverMap) {
        naverMap = map


        val target = LatLng(37.624090, 127.073162)
        val target1 = LatLng(37.655223,127.061146)// Destination (Seoul)
        val cameraUpdate = CameraUpdate.scrollTo(target)

        naverMap.moveCamera(cameraUpdate)
        naverMap.locationSource = locationSource
        naverMap.locationTrackingMode = LocationTrackingMode.Follow


        val marker = Marker()
        marker.position = target
        marker.icon = OverlayImage.fromResource(R.drawable.marker_icon) // 마커 아이콘 설정
        marker.map = naverMap


        val marker2 = Marker()
        marker2.position = target1
        marker2.icon = OverlayImage.fromResource(R.drawable.marker_icon1) // 마커 아이콘 설정
        marker2.map = naverMap


    }
}
