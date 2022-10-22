package com.alvonellos.interview.controller;

import com.alvonellos.interview.repository.KVDatabase;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class IPLookupController {
    private final DatabaseReader databaseReader;

    //get mapping for the database
    @GetMapping("/iplookup/{ip}")
    public ResponseEntity<String> getIpLookup(@PathVariable("ip") String ip) throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = databaseReader.city(ipAddress);
        Country country = response.getCountry();
        Subdivision subdivision = response.getMostSpecificSubdivision();
        City city = response.getCity();
        Postal postal = response.getPostal();
        Location location = response.getLocation();

        StringBuilder sb = new StringBuilder();
        sb.append("Country: ").append(country.getName()).append("\n");
        sb.append("Subdivision: ").append(subdivision.getName()).append("\n");;
        sb.append("City: ").append(city.getName()).append("\n");;
        sb.append("Postal: ").append(postal.getCode()).append("\n");;
        sb.append("Latitude: ").append(location.getLatitude()).append("\n");;
        sb.append("Longitude: ").append(location.getLongitude()).append("\n");;

        return ResponseEntity.ok(sb.toString());
    }
}
