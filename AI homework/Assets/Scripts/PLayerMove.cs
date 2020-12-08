using System.Collections;
using System.Collections.Generic;
using System.Threading;
using UnityEngine;

public class PLayerMove : MonoBehaviour
{
    public float speed = 5f;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        float x = transform.position.x + Input.GetAxis("Horizontal") * speed * Time.deltaTime;
        float y = transform.position.y + Input.GetAxis("Vertical") * speed * Time.deltaTime;
        transform.position = new Vector3(x, y, 0);
    }

}
